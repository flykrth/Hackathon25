package com.example.amfoss
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.amfoss.ui.theme.AmFOSSTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmFOSSTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "roleSelection") {
                    composable("roleSelection") { RoleSelectionScreen(navController) }
                    composable("firstYear") { FirstYearScreen() }
                    composable("secondYear") { SecondYearScreen() }
                    composable("thirdYear") { ThirdYearScreen() }
                    composable("fourthYear") { FourthYearScreen() }
                }
            }
        }
    }
}

@Composable
fun RoleSelectionScreen(navController: NavController) {
    val roles = listOf("First Year", "Second Year", "Third Year", "Fourth Year", "Faculty")
    var selectedRole by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("What is your role at amFOSS?", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        roles.forEach { role ->
            RoleOption(role, selectedRole == role) {
                selectedRole = role
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (selectedRole == "First Year") {
                    navController.navigate("firstYear")
                }
                if (selectedRole == "Second Year") {
                    navController.navigate("secondYear")
                }
                if (selectedRole == "Third Year") {
                    navController.navigate("thirdYear")
                }
                if (selectedRole == "Fourth Year") {
                    navController.navigate("fourthYear")
                }
            },
            enabled = selectedRole != null,
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Continue", fontSize = 18.sp)
        }
    }
}

@Composable
fun RoleOption(role: String, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFFFFC107) else Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = role,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun FirstYearScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome, First Year!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SecondYearScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome, Second Year!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ThirdYearScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome, Third Year!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun FourthYearScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome, Fourth Year!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}