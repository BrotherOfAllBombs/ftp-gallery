package com.brother.of.all.bombs.ftpimageclient.usecases;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 *
 */

public class FakeLoadImagesUseCase implements ILoadImagesUseCase {
    @Override
    public Single<List<String>> requestImageNames() {
        return Single.just(getImagesToShow());
    }

    private List<String> getImagesToShow() {
        List<String> fileNames = new ArrayList<>();
        fileNames.add("http://cdn3-www.dogtime.com/assets/uploads/gallery/30-impossibly-cute-puppies/impossibly-cute-puppy-21.jpg");
        fileNames.add("http://cdn2-www.dogtime.com/assets/uploads/gallery/30-impossibly-cute-puppies/impossibly-cute-puppy-8.jpg");
        fileNames.add("https://www.cesarsway.com/sites/newcesarsway/files/styles/large_article_preview/public/The-stages-of-puppy-growth.jpg?itok=9ptPJwY8");
        fileNames.add("https://www.cesarsway.com/sites/newcesarsway/files/styles/large_article_preview/public/All-about-puppies--Cesar%E2%80%99s-tips%2C-tricks-and-advice.jpg?itok=bi9xUvwe");
        fileNames.add("http://cdn.akc.org/content/hero/puppy-boundaries_header.jpg");
        return fileNames;
    }
}
