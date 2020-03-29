package com.qbutton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HtmlFileParser {

    public static Set<String> getFollowers(String rawFile) {

        Document htmlDoc = Jsoup.parse(rawFile);
        Elements links = htmlDoc.select(".d7ByH > a:first-child");

        Set<String> subscribers = links.stream()
                .map(Node::childNodes)
                .flatMap(List::stream)
                .map(Node::toString)
                .collect(Collectors.toSet());

        return subscribers;

    }
}
