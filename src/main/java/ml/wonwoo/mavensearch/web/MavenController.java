package ml.wonwoo.mavensearch.web;

import ml.wonwoo.mavensearch.generator.Generator;
import ml.wonwoo.mavensearch.search.MavenClient;
import ml.wonwoo.mavensearch.search.model.Docs;
import ml.wonwoo.mavensearch.search.model.Maven;
import ml.wonwoo.mavensearch.search.model.VersionDocs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MavenController {

  private final MavenClient mavenClient;
  private final Generator mavenGenerator;
  private final Paging paging;

  public MavenController(MavenClient mavenClient, Generator mavenGenerator, Paging paging) {
    this.mavenClient = mavenClient;
    this.mavenGenerator = mavenGenerator;
    this.paging = paging;
  }

  @GetMapping("/")
  public String search(Model model, @ModelAttribute SearchRequest request) {
    Maven<Docs> docs = this.mavenClient.select(request.getQ(),
        request.getRow(), request.getStart());
    model.addAttribute("maven", docs);
    model.addAttribute("request", request);
    model.addAttribute("paging",
        paging.search(request.getRow(), request.getStart(), docs.getResponse().getNumFound(), request.getQ()));
    return "home";
  }

  @GetMapping("/versions")
  public String versions(Model model, @ModelAttribute VersionRequest request) {
    Maven<VersionDocs> versions = this.mavenClient.versions(request.getG(), request.getA(),
        request.getRow(), request.getStart());
    model.addAttribute("versions", versions);
    model.addAttribute("paging",
        paging.search(request.getRow(), request.getStart(), versions.getResponse().getNumFound(), request.getA()));
    return "version";
  }

  @GetMapping("/maven")
  public String xml(Model model, @ModelAttribute VersionRequest request) {
    model.addAttribute("maven", mavenGenerator.generator(request.getG(),
        request.getA(), request.getV()));
    return "maven";
  }
}
