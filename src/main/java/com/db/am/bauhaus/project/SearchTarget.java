package com.db.am.bauhaus.project;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by ongshir on 06/04/2017.
 */
public class SearchTarget {
    public final static Target INPUT_BOX = Target.the("the search input box").located(By.id("search-query"));
    public final static Target INPUT_BOX_BUTTON = Target.the("the search input button").located(By.xpath("//button[contains(@type,'submit') and  contains(@value,'Search')]"));
    public final static Target TOP_CATEGORIES_HEADER = Target.the("the top categories header").located(By.cssSelector("h4.pb-xs-1-5"));
    public final static Target ALL_CATEGORIES_HEADER = Target.the("the all categories header").located(By.xpath("//h1[contains(@class,'display-inline text-smaller')]"));
}
