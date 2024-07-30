package utils

import model.ImageModel
import sharedelementwithsafeargnav.composeapp.generated.resources.Res
import sharedelementwithsafeargnav.composeapp.generated.resources.image1
import sharedelementwithsafeargnav.composeapp.generated.resources.image2
import sharedelementwithsafeargnav.composeapp.generated.resources.image3
import sharedelementwithsafeargnav.composeapp.generated.resources.image4
import sharedelementwithsafeargnav.composeapp.generated.resources.image5

object CommonUtils {

    val imagesList = listOf(
        ImageModel(
            1,
            Res.drawable.image1,
            "Flower One",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        ),
        ImageModel(
            2,
            Res.drawable.image2,
            "Flower Two",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        ),
        ImageModel(
            3,
            Res.drawable.image3,
            "Flower Three",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        ),
        ImageModel(
            4,
            Res.drawable.image4,
            "Flower Four",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        ),
        ImageModel(
            5,
            Res.drawable.image5,
            "Flower Five",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        )
    )
}