package com.yanfalcao.talkbacktips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.talkbacktips.ui.theme.TalkBackTipsTheme
import com.yanfalcao.talkbacktips.widget.DefaultTopAppBar

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TalkBackTipsTheme {
                BodyTextField()
            }
        }
    }
}

@Composable
fun BodyTextField() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultTopAppBar(stringResource(R.string.text_field_tip))
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
                    text = stringResource(R.string.text_field_bad_example),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 25.dp),
                    textAlign = TextAlign.Center
                )

                TextFieldBadExample()

                Text(
                    text = stringResource(R.string.text_field_good_example),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 45.dp ,bottom = 25.dp),
                    textAlign = TextAlign.Center
                )

                TextFieldGoodExample()
            }
        }
    }
}

@Composable
fun TextFieldBadExample() {
    val text = remember { mutableStateOf("") }
    val typeHereText = stringResource(R.string.label_first_name)

    Column(
        modifier =
        Modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.first_name),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 12.dp),
        )

        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text(typeHereText) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun TextFieldGoodExample() {
    val text = remember { mutableStateOf("") }
    val cdTextField = stringResource(R.string.cd_enter_first_name)
    val typeHereText = stringResource(R.string.label_first_name)

    Column(
        modifier =
        Modifier
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.first_name),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 12.dp),
        )

        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = {
                Text(
                    typeHereText,
                    modifier = Modifier.semantics {
                        contentDescription = cdTextField
                    }
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextFieldPreview() {
    TalkBackTipsTheme {
        BodyTextField()
    }
}