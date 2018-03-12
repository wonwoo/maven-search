package ml.wonwoo.mavensearch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.result.view.Rendering;

import ml.wonwoo.mavensearch.search.MavenRepository;

@Controller
public class MavenController {

  private final MavenRepository mavenRepository;

  public MavenController(MavenRepository mavenRepository) {
    this.mavenRepository = mavenRepository;
  }

  @GetMapping("/")
  public Rendering search(@RequestParam(defaultValue = "") String q,
                          @RequestParam(defaultValue = "20") int row,
                          @RequestParam(defaultValue = "0") int start) {
    return Rendering
        .view("home")
        .modelAttribute("maven", this.mavenRepository.select(q, row, start))
        .build();
  }

  @GetMapping("/versions")
  public Rendering versions(@RequestParam String g, @RequestParam String a,
                            @RequestParam(defaultValue = "20") int row,
                            @RequestParam(defaultValue = "0") int start) {
    return Rendering
        .view("version")
        .modelAttribute("versions",
            this.mavenRepository.versions(g, a, row, start))
        .build();
  }
}
