package com.example.amfoss.ui.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegistrationScreen(viewModel: RegistrationViewModel = viewModel()) {
    var rollNo by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var sex by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var hostel by remember { mutableStateOf("") }
    var groupId by remember { mutableStateOf("") }

    val registrationState by viewModel.registrationState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Register", fontSize = 24.sp)

        OutlinedTextField(value = rollNo, onValueChange = { rollNo = it }, label = { Text("Roll No") })
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(value = sex, onValueChange = { sex = it }, label = { Text("Sex") })
        OutlinedTextField(value = year, onValueChange = { year = it }, label = { Text("Year") })
        OutlinedTextField(value = hostel, onValueChange = { hostel = it }, label = { Text("Hostel") })
        OutlinedTextField(value = groupId, onValueChange = { groupId = it }, label = { Text("Group ID") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.registerMember(rollNo, name, email, sex, year.toInt(), hostel, groupId) }
        ) {
            Text("Register")
        }

        when (registrationState) {
            is RegistrationState.Loading -> CircularProgressIndicator()
            is RegistrationState.Success -> Text("Registration Successful!", color = MaterialTheme.colorScheme.primary)
            is RegistrationState.Error -> Text("Registration Failed", color = MaterialTheme.colorScheme.error)
            else -> {}
        }
    }
}

