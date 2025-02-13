package com.yanfalcao.talkbacktips

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.talkbacktips.ui.theme.TalkBackTipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TalkBackTipsTheme {
                BodyMain()
            }
        }
    }
}

@Composable
fun BodyMain() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            TipsList()
        }
    }
}

@Composable
fun TipsList() {
    val activity = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.title_tips_list),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(32.dp),
            textAlign = TextAlign.Center
        )

        Button(
            onClick = { activity.startActivity(Intent(activity, GroupingActivity::class.java)) },
            modifier = Modifier
        ) {
            Text(
                text = stringResource(R.string.grouping_tip),
            )
        }

        Button(
            onClick = { activity.startActivity(Intent(activity, TextFieldActivity::class.java)) },
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(
                text = stringResource(R.string.text_field_tip),
            )
        }

        Button(
            onClick = { activity.startActivity(Intent(activity, StateChangeActivity::class.java)) },
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(
                text = stringResource(R.string.state_change_tip),
            )
        }

        Button(
            onClick = { activity.startActivity(Intent(activity, CustomActionsActivity::class.java)) },
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(
                text = stringResource(R.string.custom_actions_tip),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    TalkBackTipsTheme {
        BodyMain()
    }
}