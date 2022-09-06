package br.com.nicolas.storagepdf.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nicolas.storagepdf.ui.theme.*

@Composable
fun ContainerIcon(
    icon: ImageVector = Icons.Default.Done,
    iconTint: Color = Color.Black,
    shapeBackground: Shape = RoundedCornerShape(10.dp),
    backgroundColor: Color = ColorDefaultCard
) {
    Box(
        modifier = Modifier
            .size(35.dp)
            .clip(shapeBackground)
            .background(backgroundColor), contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = "", tint = iconTint, modifier = Modifier.size(20.dp))
    }
}

data class WithText(
    var text: String = "Script file",
    var icon: ImageVector
)

fun providerCardUsage() = listOf(
    WithText(text = "Script file", icon = Icons.Default.Refresh),
    WithText(text = "Office Docs", icon = Icons.Default.MailOutline),
    WithText(text = "Cart file", icon = Icons.Default.ShoppingCart)
)

@Composable
fun ContainerIconWithText(
    text: String = "Script file",
    icon: ImageVector = Icons.Default.Done,
    iconTint: Color = Color.Black,
    shapeBackground: Shape = RoundedCornerShape(10.dp),
    backgroundColor: Color = BlackGray2
) {
    Column(
        modifier = Modifier
            .size(height = 100.dp, width = 105.dp)
            .clip(shapeBackground)
            .fillMaxWidth()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, contentDescription = "", tint = iconTint, modifier = Modifier.size(25.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.h3,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun Preee() {
    StoragePdfTheme {
        ContainerRecentActivity()
    }
}

@Composable
fun ContainerRecentActivity(
    icon : ImageVector = Icons.Default.Face,
    background : Color = Pink
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(BlackGray2)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        ContainerIcon(icon = icon, backgroundColor = background)
        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
        Column {
            Text(text = "Recovery code", style = MaterialTheme.typography.h2, fontSize = 14.sp)
            Spacer(modifier = Modifier.size(5.dp))
            Row {
                Text(
                    text = "1,4MB",
                    style = MaterialTheme.typography.h4,
                    fontSize = 12.sp,
                    color = TextGray
                )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(
                    text = "Most recent",
                    style = MaterialTheme.typography.h4,
                    fontSize = 12.sp,
                    color = TextGray
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(Icons.Default.MoreVert, contentDescription = "",)
    }
}