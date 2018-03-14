package ml.wonwoo.mavensearch.web;

import org.springframework.stereotype.Component;

@Component
public class Paging {

    private final static String HELL = "<li><span class=\"pagination-ellipsis\">&hellip;</span></li>";

    public String search(int size, int start, int totalCount, String query) {
        String nav = "<ul class=\"pagination-list\">";
        int last = (int) Math.ceil(((double) totalCount / size));
        int current = (int) Math.ceil((double) start / size) + 1;
        if (current > 1) {
            nav += "<li><a href=\"?q=" + query + "&row=" + size + " &start=0\" class=\"pagination-link\" aria-label=\"Goto page\">1</a></li>";
            nav += HELL;
            nav += "<li><a href=\"?q=" + query + "&row=" + size + "&start=" + (start - size)
                    + "\"  class=\"pagination-link\" aria-label=\"Goto page\">" + (current - 1) + "</a></li>";
        }
        nav += "<li><a class=\"pagination-link is-current\" aria-label=\"Page\" aria-current=\"page\">" + current + "</a></li>";
        if ((current + 1) <= last) {
            nav += "<li><a href=\"?q=" + query + "&row=" + size + "&start=" + (start + size)
                    + "\" class=\"pagination-link\" aria-label=\"Goto page \">" + (current
                    + 1) + "</a></li>";
            nav += HELL;
            nav += "<li><a href=\"?q=" + query + "&row=" + size + "&start=" + ((last * size) - size)
                    + "\" class=\"pagination-link\" aria-label=\"Goto page \">" + last
                    + "</a></li>";
        }
        nav += "</ul>";
        return nav;
    }

    public String versions(int size, int start, int totalCount, String groupId, String artifactId) {
        String nav = "<ul class=\"pagination-list\">";

        int last = (int) Math.ceil(((double) totalCount / size));
        int current = (int) Math.ceil((double) start / size) + 1;
        if (current > 1) {
            nav += "<li><a href=\"?g=" + groupId + "&a=" + artifactId + "&row=" + size
                    + " &start=0\" class=\"pagination-link\" aria-label=\"Goto page\">1</a></li>";
            nav += HELL;
            nav += "<li><a href=\"?g=" + groupId + "&a=" + artifactId + "&row=" + size + "&start=" + (start - size)
                    + "\"  class=\"pagination-link\" aria-label=\"Goto page\">" + (current - 1) + "</a></li>";
        }
        nav += "<li><a class=\"pagination-link is-current\" aria-label=\"Page\" aria-current=\"page\">" + current + "</a></li>";
        if ((current + 1) <= last) {
            nav += "<li><a href=\"?g=" + groupId + "&a=" + artifactId + "&row=" + size + "&start=" + (start + size)
                    + "\" class=\"pagination-link\" aria-label=\"Goto page \">" + (current
                    + 1) + "</a></li>";
            nav += HELL;
            nav += "<li><a href=\"?g=" + groupId + "&a=" + artifactId + "&row=" + size + "&start=" + ((last * size) - size)
                    + "\" class=\"pagination-link\" aria-label=\"Goto page \">" + last
                    + "</a></li>";
        }
        nav += "</ul>";
        return nav;
    }
}
