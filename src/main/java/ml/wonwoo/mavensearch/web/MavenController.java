package ml.wonwoo.mavensearch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.reactive.result.view.Rendering;

import ml.wonwoo.mavensearch.generator.Generator;
import ml.wonwoo.mavensearch.search.MavenRepository;
import ml.wonwoo.mavensearch.search.model.Docs;
import ml.wonwoo.mavensearch.search.model.Maven;
import reactor.core.publisher.Mono;

@Controller
public class MavenController {

  private final MavenRepository mavenRepository;
  private final Generator mavenGenerator;
  private final Paging paging;

  public MavenController(MavenRepository mavenRepository, Generator mavenGenerator, Paging paging) {
    this.mavenRepository = mavenRepository;
    this.mavenGenerator = mavenGenerator;
    this.paging = paging;
  }

  @GetMapping("/")
  public Rendering search(@ModelAttribute SearchRequest request) {
    Mono<Maven<Docs>> select = this.mavenRepository.select(request.getQ(),
            request.getRow(), request.getStart());
    return Rendering
        .view("home")
        .modelAttribute("maven", select)
        .modelAttribute("paging", select.map(docsMaven ->
                paging.navigator(request.getRow(),
                request.getStart(),
                docsMaven.getResponse().getNumFound())))
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
