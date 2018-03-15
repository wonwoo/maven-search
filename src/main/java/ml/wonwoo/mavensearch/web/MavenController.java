package ml.wonwoo.mavensearch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.reactive.result.view.Rendering;

import ml.wonwoo.mavensearch.generator.Generator;
import ml.wonwoo.mavensearch.search.MavenClient;
import ml.wonwoo.mavensearch.search.model.Docs;
import ml.wonwoo.mavensearch.search.model.Maven;
import ml.wonwoo.mavensearch.search.model.VersionDocs;
import reactor.core.publisher.Mono;

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
  public Rendering search(@ModelAttribute SearchRequest request) {
    Mono<Maven<Docs>> select = this.mavenClient.select(request.getQ(),
            request.getRow(), request.getStart());
    return Rendering
            .view("home")
            .modelAttribute("maven", select)
            .modelAttribute("paging", select.map(docsMaven ->
                    paging.search(request.getRow(),
                            request.getStart(),
                            docsMaven.getResponse().getNumFound(), request.getQ())))
            .modelAttribute("request", request)
            .build();
  }

  @GetMapping("/versions")
  public Rendering versions(@ModelAttribute VersionRequest request) {
    Mono<Maven<VersionDocs>> versions = this.mavenClient.versions(request.getG(), request.getA(),
            request.getRow(), request.getStart());
    return Rendering
            .view("version")
            .modelAttribute("versions",
                    versions)
            .modelAttribute("paging", versions.map(docsMaven ->
                    paging.versions(request.getRow(),
                            request.getStart(),
                            docsMaven.getResponse().getNumFound(), request.getG(), request.getA())))
            .build();
  }

  @GetMapping("/maven")
  public Rendering xml(@ModelAttribute VersionRequest request) {
    return Rendering
            .view("maven")
            .modelAttribute("maven", mavenGenerator.generator(request.getG(),
                    request.getA(), request.getV()))
            .build();
  }
}
