package com.yanfalcao.talkbacktips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.talkbacktips.ui.theme.TalkBackTipsTheme
import com.yanfalcao.talkbacktips.widget.DefaultTopAppBar

class StateChangeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TalkBackTipsTheme {
                BodyStateChangeTip(
                )
            }
        }
    }
}

@Composable
fun BodyStateChangeTip() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultTopAppBar(stringResource(R.string.state_change_tip))
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.state_change_bad_example),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 45.dp ,bottom = 25.dp),
                    textAlign = TextAlign.Center
                )

                StateChangeBadExample()

                Text(
                    text = stringResource(R.string.state_change_good_example),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 45.dp ,bottom = 25.dp),
                    textAlign = TextAlign.Center
                )

                StateChangeGoodExample()
            }
        }
    }
}

@Composable
fun StateChangeBadExample() {
    var favorite by remember { mutableStateOf(false) }
    val favoriteIcon = if (favorite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder

    IconButton(
        onClick = { favorite = !favorite }
    ) {
        Icon(
            modifier = Modifier.size(35.dp),
            imageVector = favoriteIcon,
            contentDescription = stringResource(R.string.favorite)
        )
    }
}

@Composable
fun StateChangeGoodExample() {
    var favorite by remember { mutableStateOf(false) }
    val favoriteIcon = if (favorite) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder

    IconToggleButton(
        checked = favorite,
        onCheckedChange = { favorite = it }
    ) {
        Icon(
            modifier = Modifier.size(35.dp),
            imageVector = favoriteIcon,
            contentDescription = stringResource(R.string.favorite)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TalkBackTipsTheme {
        BodyStateChangeTip()
    }
}