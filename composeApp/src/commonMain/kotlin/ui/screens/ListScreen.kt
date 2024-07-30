package ui.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.ImageModel
import org.jetbrains.compose.resources.painterResource
import utils.CommonUtils

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ListScreen(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope, navigate: (id: Int) -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        items(CommonUtils.imagesList) { item ->
            ImageItem(sharedTransitionScope, animatedContentScope, item) {
                navigate(item.id)
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ImageItem(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope, imageModel: ImageModel, onClicked: (id: Int) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth().clickable { onClicked(imageModel.id) }) {

        with(sharedTransitionScope) {
            Image(
                painter = painterResource(imageModel.drawableResource),
                contentScale = ContentScale.Crop,
                contentDescription = imageModel.name,
                modifier = Modifier.size(100.dp)
                    .sharedElement(
                        rememberSharedContentState(key = imageModel.id),
                        animatedVisibilityScope = animatedContentScope,
                        boundsTransform = { initialRect, targetRect ->
                            spring(
                                dampingRatio = 0.8f,
                                stiffness = 380f
                            )
                        }
                    )
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = imageModel.name,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier.sharedElement(
                    rememberSharedContentState(key = imageModel.name),
                    animatedVisibilityScope = animatedContentScope,
                    boundsTransform = { initialRect, targetRect ->
                        spring(
                            dampingRatio = 0.8f,
                            stiffness = 380f
                        )
                    }
                )
            )
        }

    }
}