package br.com.nicolas.storagepdf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nicolas.storagepdf.components.ContainerIcon
import br.com.nicolas.storagepdf.components.ContainerIconWithText
import br.com.nicolas.storagepdf.components.ContainerRecentActivity
import br.com.nicolas.storagepdf.components.providerCardUsage
import br.com.nicolas.storagepdf.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoragePdfTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Container()
                }
            }
        }
    }
}

@Composable
fun Container() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(BackgroundApplication)
            .padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        TopBar()
        CardStorage()
        CardFiles()
        RecentActivity()
    }
}

@Composable
fun TopBar() {

    var search by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = CenterVertically
        ) {
            Text(
                text = "Storage",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.weight(1f)
            )
            ContainerIcon(Icons.Filled.Favorite)
            Spacer(modifier = Modifier.size(10.dp))
            ContainerIcon(Icons.Default.Add, iconTint = Color.White, backgroundColor = BlackGrey)
        }
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(BorderStroke(1.dp, color = Gray100), RoundedCornerShape(15.dp)),
            value = search,
            onValueChange = { search = it },
            placeholder = {
                Text(
                    text = "Search file",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h2,
                )
            },
            enabled = true,
            isError = false,
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = BlackGrey, modifier = Modifier.padding(start = 5.dp),
                    contentDescription = ""
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Gray100,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
            ),
        )
    }
}

@Preview
@Composable
fun CardStorage() {
    Spacer(modifier = Modifier.size(20.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Yellow)
    ) {
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(20.dp)) {
            Image(
                imageVector = Icons.Default.Share,
                contentDescription = "",
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Free",
                style = MaterialTheme.typography.h3,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = "Storage", style = MaterialTheme.typography.h4,
            fontSize = 15.sp,
            color = BlackGray,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = CenterVertically
        ) {
            Text(
                text = "12,5b", style = MaterialTheme.typography.h2,
                fontSize = 30.sp,
                modifier = Modifier.alignByBaseline(),
                color = Color.Black,
            )
            Text(
                text = "/ 50Gb",
                style = MaterialTheme.typography.h4,
                color = BlackGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .alignByBaseline()
            )
            Spacer(modifier = Modifier.weight(1f))
            ContainerIcon(icon = Icons.Default.Edit, Color.Black, backgroundColor = Color.White)
        }
    }
}

@Composable
fun CardFiles() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Shared file", style = MaterialTheme.typography.h3, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Image(Icons.Default.KeyboardArrowRight, contentDescription = "")
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            items(items = providerCardUsage()) { item ->
                ContainerIconWithText(text = item.text, icon = item.icon)
            }
        }
    }
}


@Composable
fun RecentActivity() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Recent Activity", style = MaterialTheme.typography.h3, fontSize = 16.sp)
        Spacer(modifier = Modifier.size(20.dp))
        ContainerRecentActivity(icon = Icons.Default.Notifications)
        Spacer(modifier = Modifier.size(10.dp))
         ContainerRecentActivity(icon = Icons.Default.Settings, background = BackgroundContainerIconPink)
        Spacer(modifier = Modifier.size(10.dp))
        ContainerRecentActivity(icon = Icons.Default.Info, background = BackgroundContainerIconBlue)
    }
}
