import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Bienvenido a tu perfil",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Sección: Información de cuenta
        Text(
            text = "Información de cuenta",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Datos del usuario
        Column(
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        ) {
            ProfileItem(label = "Usuario", value = "Mauricio Garzon")
            ProfileItem(label = "Email", value = "mgarzon@gmail.com")
            ProfileItem(label = "Dirección", value = "Querétaro")
            ProfileItem(label = "Saldo atual", value = "$35,000 MXN")
            ProfileItem(label = "Moneda preferida", value = "MXN")
        }

        // Línea divisoria
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Sección: Información adicional
        Text(
            text = "Información Adicional",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Subsección: Noticias del mundo
        Text(
            text = "Noticias del mundo",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        // Items de lista
        Column(
            modifier = Modifier.padding(start = 32.dp)
        ) {
            Text("→ Notificaciones", modifier = Modifier.padding(bottom = 8.dp))
            Text("→ Mercado de Acciones", modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(
            text = label,
            color = Color.Gray,
            fontSize = 14.sp
        )
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}