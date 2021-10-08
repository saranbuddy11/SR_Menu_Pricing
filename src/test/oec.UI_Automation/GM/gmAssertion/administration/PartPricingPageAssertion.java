package GM.gmAssertion.administration;

import GM.gmObjectRepository.administration.PartPricingPage;
import base.AbstractAssertion;
import model.SearchReasons;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PartPricingPageAssertion extends AbstractAssertion<PartPricingPage> {

    public PartPricingPageAssertion assertAtPartPricingTab() {
        assertThat(functionalLibrary.getColor("Part Pricing")).as("Verify that User at Part Pricing").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public PartPricingPageAssertion assertIfExceptByCategoryTabIsAccessible() {
        assertThat(functionalLibrary.getColor("Except. by Category")).as("Verify that Except. by Category tab is accessible").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public PartPricingPageAssertion assertIfExceptByPartNumberTabIsAccessible() {
        assertThat(functionalLibrary.getColor("Except. by Part#")).as("Verify that Except. by Part# tab is accessible").isEqualTo(functionalLibrary.ORANGE_COLOR_HEX_CODE);
        return this;
    }

    public PartPricingPageAssertion assertIfPartCategoriesListAvailable() {
        assertThat(functionalLibrary.isPartCategoriesListDisplayed()).as("Verify that  A window pop ups with the list of all part categories available.").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertIfSearchedCategoryVisibleInList(String part) {
        int size = functionalLibrary.getPartCategoriesSearchSize();
        for (int i = 1; i <size; i++) {
            assertThat(functionalLibrary.getPartCategorySearchResult(i)).as("Verify that Horn category should be visible on the list").contains(part);
        }
        return this;
    }

    public PartPricingPageAssertion assertIfPartRecordCreated(String part) {
        assertThat(functionalLibrary.getPartCategoriesDescription()).as("Verify that Record for Horn is created or updated.").isEqualTo(part);
        return this;
    }

    public PartPricingPageAssertion assertIfCostAndSellingPriceIsEditable() {
        assertThat(functionalLibrary.isCostAndSellingPriceAreEditable()).as("Verify that Record with part is added to the list where is possible to Cost, Selling Price is Edit.").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertIfRecordWithValuesIsStored(String price) {
        assertThat(functionalLibrary.getSellingPrice()).as("Verify that Record with values is stored on Except. by Part# list ").isEqualTo(price);
        return this;
    }

    public PartPricingPageAssertion assertIfInvalidFileFormatErrorMsgDisplayed(String expectedErrorMsg) {
        assertThat(functionalLibrary.getErrorPopUp()).as("Verify that Error message displayed ‘The uploaded file is invalid. It must exist and must be .csv file format’.").isEqualTo(expectedErrorMsg);
        return this;
    }

    public PartPricingPageAssertion assertIfUploadDataSuccessfully() {
        assertThat(functionalLibrary.isUploadedSuccessfullyMsgDisplayed()).as("Verify that Uploads successfully").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertIfFileDownloadedSuccessfully(String fileName) {
        assertThat(functionalLibrary.isFileDownloaded(fileName)).as("Verify that Downloaded successfully").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertTheFileViewerLoads() {
        assertThat(functionalLibrary.isUploadedFileNameDisplayed()).as("Verify that The file viewer loads").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertTheTheStockUploadFileViewerCloses() {
        assertThat(functionalLibrary.isStockUploadTabDisplayed()).as("Verify that The file viewer closes.").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertAtStockUploadTab() {
        assertThat(functionalLibrary.getColor("Stock Upload")).as("Verify that User at Stock Upload").isEqualTo(functionalLibrary.BLACK_COLOR_HEX_CODE);
        return this;
    }

    public PartPricingPageAssertion assertIfStockUploadDataSuccessfully() {
        assertThat(functionalLibrary.isStockFileUploadedSuccessfullyMsgDisplayed()).as("Verify that Uploads successfully").isTrue();
        return this;
    }
    public PartPricingPageAssertion assertTheTheFileViewerCloses() {
        assertThat(functionalLibrary.isPartPricingTabDisplayed()).as("Verify that The file viewer closes.").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertTheStockUploadFileViewerLoads() {
        assertThat(functionalLibrary.isStockUploadedFileNameDisplayed()).as("Verify that The file viewer loads").isTrue();
        return this;
    }

    public PartPricingPageAssertion assertIfFieldAmendable(String date, int index) {
        assertThat(functionalLibrary.getUpdatedDate(index)).as("Field amendable").isEqualTo(date);
        return this;
    }

    public PartPricingPageAssertion assertIfSearchReasonsAreAvailable(List<String> reasons) {
        assertThat(functionalLibrary.getSearchReasons()).as("The dropdown box gives 3 reasons.").isEqualTo(reasons);
        return this;
    }

    public PartPricingPageAssertion assertThatSelectedSearchReasonsAreAvailable(SearchReasons reasons) {
        assertThat(functionalLibrary.getSelectedSearchReason()).as("Each reason can be selected.").isEqualTo(reasons.getReason());
        return this;
    }

    public PartPricingPageAssertion assertIfSearchedLostAndSaleDataCorrect(SearchReasons reason) {
        int size = functionalLibrary.getReasonResultSize();
        for (int i = 1; i <size; i++) {
            assertThat(functionalLibrary.getLostSalesSearchResult(i)).as("Results depended on what has been searched will be displayed.").isEqualTo(reason.getReason());
        }
        return this;
    }
}