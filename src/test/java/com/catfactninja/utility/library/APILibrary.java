package com.catfactninja.utility.library;

import com.catfactninja.pages.ApiBasePage;
import com.catfactninja.pages.ApiBreedsPage;
import com.catfactninja.pages.ApiFactsPage;

public class APILibrary {
    private ApiBasePage apiBasePage;
    private ApiBreedsPage breedsPage;
    private ApiFactsPage factsPage;

    public APILibrary() {
        this.apiBasePage = new ApiBasePage();
        this.breedsPage = new ApiBreedsPage();
        this.factsPage = new ApiFactsPage();
    }

    public ApiBasePage getApiBasePage() {
        return apiBasePage;
    }

    public ApiBreedsPage getBreedsPage() {
        return breedsPage;
    }

    public ApiFactsPage getFactsPage() {
        return factsPage;
    }
}
