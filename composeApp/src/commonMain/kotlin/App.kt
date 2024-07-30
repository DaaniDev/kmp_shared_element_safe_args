import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import sharedelementwithsafeargnav.composeapp.generated.resources.Res
import sharedelementwithsafeargnav.composeapp.generated.resources.compose_multiplatform
import ui.screens.DetailScreen
import ui.screens.ListScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {

        SharedTransitionLayout {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = ListScreenRoute) {
                composable<ListScreenRoute> {
                    ListScreen(
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedContentScope = this
                    ) { id ->
                        navController.navigate(DetailScreenRoute(id))
                    }
                }

                composable<DetailScreenRoute> {
                    DetailScreen(
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedContentScope = this,
                        id = it.arguments?.getInt("imageId")!!.toInt()
                    ) {
                        navController.popBackStack()
                    }
                }
            }
        }

    }
}

@Serializable
object ListScreenRoute

@Serializable
data class DetailScreenRoute(val imageId: Int)