# Coding Challenge

It took me almost 210 minutes to do the challenge.

I had some issues with loading the images while keeping their original proportions.
At first, I tried to calculate the height using the width of the ViewHolder on the Adapter.
However, the app was crashing because the width of the ViewHolder was defined as match_parent. As a result,  when trying to load the image, the final width hadn't been calculated yet.
To solve that, I changed the width to use the size half of the size of the screen instead.

After that, I had another issue where the StaggeredGridLayoutManager was placing all the images on only the first column. The problem was that the recyclerView handled the image as if it had 0 height. To solve this, I added a minHeight.

These two issues took me around 90 minutes, which is why it took me so long.

I chose to use an **MVVM architecture** because I wanted to use the jetpack libraries that helped me to develop the app faster. Also, I could clearly divide the presentation layer and the data layer.

The libraries used were:

- **Picasso**: A library for downloading images and loading them into views. I used this because it has a method to resize the image size based on the size of one of its sides.
- **Kotlin coroutines**: A library to manage threads. I used this because it has an integration with the viewModel from jetpack.
- **Retrofit**: An Http client for Android. I used this because the declaration of requests is straightforward, and it has integrations with multiple serialization libraries.
- **Gson**: A library for JSON serialization and deserialization. I used this because I had already used it on other projects.
- **Dagger Hilt**: A dependency injection library. I used this because it helped me to construct the dependencies each class had and also because it has integrations with Android classes.
