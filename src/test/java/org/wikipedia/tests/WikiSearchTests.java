package org.wikipedia.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiSearchTests extends TestBase {

    private static final String SEARCH_TEXT = "Apple Inc.",
            DESCRIPTION = "American multinational technology company",
            NON_EXITING_SEARCH_TEXT = "ВАПМИРТОЬ";

    @Test
    @DisplayName("При поиске статьи о компании " + SEARCH_TEXT + " выводится соответствуещее описание статьи")
    public void correctDescriptionVisibleAfterSearchingAppleInc() {

        step("Вводим в поисковую строку " + SEARCH_TEXT, () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(SEARCH_TEXT);
        });

        step("Проверяем, что в найденной строке присутствует описание " + DESCRIPTION, () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_description")).first().shouldHave(text(DESCRIPTION));
        });

    }

    @Test
    @DisplayName("При вводе несуществующего запроса в результатах поиска не отображаются статьи")
    public void correctMessageVisibleAfterSearchingNonExisting() {

        step("Вводим в поисковую строку " + NON_EXITING_SEARCH_TEXT, () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(NON_EXITING_SEARCH_TEXT);
        });

        step("Проверяем, что в результатах поиска отсутствуют статьи", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldBe(empty);
        });

    }


}
