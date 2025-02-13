package com.yanfalcao.talkbacktips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.talkbacktips.ui.theme.TalkBackTipsTheme
import com.yanfalcao.talkbacktips.widget.DefaultTopAppBar

class CustomActionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TalkBackTipsTheme {
                BodyCustomActionsTip()
            }
        }
    }
}

@Composable
fun BodyCustomActionsTip() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultTopAppBar(stringResource(R.string.custom_actions_tip))
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.custom_actions_good_example),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 25.dp),
                )

                repeat(4) {
                    ListTileExample(
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(size = 15.dp),
                            )
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun ListTileExample(modifier: Modifier = Modifier) {
    var isFavorite by remember { mutableStateOf(false) }
    val favoriteActionLabel = if(isFavorite) {
        stringResource (R.string.remove_from_favorite)
    } else {
        stringResource(R.string.add_to_favorite)
    }

    Row(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .clickable {
                // Open recipe details
            }
            .semantics(mergeDescendants = true) {
                customActions = listOf(
                    CustomAccessibilityAction(
                        label = favoriteActionLabel,
                        action = {
                            isFavorite = !isFavorite
                            // Return a boolean result indicating whether the action is successfully handled
                            true
                        }
                    )
                )
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column{
            Text(
                text = stringResource(R.string.recipe_name_example),
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.titleLarge,
            )

            Text(
                text = stringResource(R.string.recipe_prep_time_example),
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 12.dp),
            )
        }

        IconFavoriteButton(
            modifier = Modifier.clearAndSetSemantics { },
            favoriteState = isFavorite,
            onToogleFavorite = { isFavorite = it },
        )
    }
}

@Composable
fun IconFavoriteButton(
    modifier: Modifier = Modifier,
    favoriteState: Boolean = false,
    onToogleFavorite: (Boolean) -> Unit = {},
) {
    val favoriteIcon = if (favoriteState) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder

    IconToggleButton(
        modifier = modifier,
        checked = favoriteState,
        onCheckedChange = onToogleFavorite,
        colors = getIconButtonColors()
    ) {
        Icon(
            modifier = Modifier.size(35.dp),
            imageVector = favoriteIcon,
            contentDescription = stringResource(R.string.favorite),
        )
    }
}

@Composable
fun getIconButtonColors() = IconToggleButtonColors(
    contentColor = MaterialTheme.colorScheme.background,
    containerColor = MaterialTheme.colorScheme.primary,
    checkedContentColor = Color.Red,
    checkedContainerColor = MaterialTheme.colorScheme.primary,
    disabledContentColor = MaterialTheme.colorScheme.background,
    disabledContainerColor = MaterialTheme.colorScheme.primary,
)

@Preview(showBackground = true)
@Composable
fun CustomActionsPreview() {
    TalkBackTipsTheme {
        BodyCustomActionsTip()
    }
}