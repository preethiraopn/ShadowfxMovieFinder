# ShadowfxMovieFinder
Sample Application which loads movie data from OMDB and based on movie title search

## This has the following features
- enable searching by typing a movie / show name(Search as user types)
- Pagination for users to paginate across results
- Use a default search key to get the list for the initial load state
- Use your own design 
- MVVM architecture with Kotlin 
- Handled normal scenarios and failure cases(app should not crash)
- have written instrumented unit tests

#### Tricky part was there was certificate issue with the **OMDB movie image** downloading site and we had create our own GlideModule.
https://github.com/bumptech/glide/issues/1726
