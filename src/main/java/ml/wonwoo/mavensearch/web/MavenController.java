package ml.wonwoo.mavensearch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.reactive.result.view.Rendering;

import ml.wonwoo.mavensearch.generator.Generator;
import ml.wonwoo.mavensearch.search.MavenRepository;

@Controller
public class MavenController {

  private final MavenRepository mavenRepository;
  private final Generator mavenGenerator;

  public MavenController(MavenRepository mavenRepository, Generator mavenGenerator) {
    this.mavenRepository = mavenRepository;
    this.mavenGenerator = mavenGenerator;
  }

  @GetMapping("/")
  public Rendering search(@ModelAttribute SearchRequest request) {
    return Rendering
        .view("home")
        .modelAttribute("maven", this.mavenRepository.select(request.getQ(),
                request.getRow(), request.getStart()))
        .modelAttribute("request", request)
        .build();
  }

  @GetMapping("/versions")
  public Rendering versions(@ModelAttribute VersionRequest request) {
    return Rendering
        .view("version")
        .modelAttribute("versions",
            this.mavenRepository.versions(request.getG(), request.getA(),
                    request.getRow(), request.getStart()))
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
