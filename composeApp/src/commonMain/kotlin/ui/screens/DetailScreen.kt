package ui.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import utils.CommonUtils

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailScreen(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope, id: Int, navigate: () -> Unit
) {

    val imageModel = CommonUtils.imagesList.find { it.id == id }

    imageModel?.let { imageObj ->

        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = imageObj.name)
                }, navigationIcon = {
                    IconButton(onClick = {
                        navigate()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
            },
        ) {

            Column(modifier = Modifier.fillMaxSize()) {

                with(sharedTransitionScope) {

                    Image(
                        painter = painterResource(imageObj.drawableResource),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.sharedElement(
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

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = imageObj.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
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

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = imageObj.description,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        }
    }
}