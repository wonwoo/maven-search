package ml.wonwoo.mavensearch.web;

import org.springframework.stereotype.Component;

@Component
public class Paging {

    public String navigator(int size, int start, int totalCount) {
        String nav = "<ul class=\"pagination-list\">";
        String hell = "<li><span class=\"pagination-ellipsis\">&hellip;</span></li>";
        int last = (int) Math.ceil(((double) totalCount / size));
        int current = (int) Math.ceil((double) start / size) + 1;
        if (current > 1) {
            nav += "<li><a class=\"pagination-link\" aria-label=\"Goto page\">1</a></li>";
            nav += hell;
            nav += " <li><a class=\"pagination-link\" aria-label=\"Goto page\">" + (current - 1) + "</a></li>";
        }
        nav += "<li><a class=\"pagination-link is-current\" aria-label=\"Page\" aria-current=\"page\">" + current + "</a></li>";
        if((current + 1) < last) {
            nav += " <li><a class=\"pagination-link\" aria-label=\"Goto page \">" + (current + 1) + "</a></li>";
            nav += hell;
            nav += "<li><a class=\"pagination-link\" aria-label=\"Goto page \">" + last + "</a></li>";
        }
        return nav;
    }
}
