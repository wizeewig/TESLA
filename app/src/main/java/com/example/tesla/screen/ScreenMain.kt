
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tesla.Routes
import com.example.tesla.screen.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun ScreenMain(){
    val navController = rememberNavController()
    NavHost(navController = navController,  startDestination = Routes.splashscreen.route) {

        composable(Routes.splashscreen.route){
            splashscreen(navController = navController)
        }

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.SignUp.route) {
            SignUp(navController = navController)
        }

        composable(Routes.ForgotPassword.route) { navBackStack ->
            ForgotPassword(navController = navController)
        }

        composable(Routes.Rules.route) {
            Rules(navController = navController)
        }

        composable(Routes.level1.route) {
            level1(navController = navController)
        }

        composable(Routes.level2.route) {
            level2(navController = navController)
        }

        composable(Routes.level3.route) {
            level3(navController = navController)
        }

        composable(Routes.level4.route) {
            level4(navController = navController)
        }

        composable(Routes.level5.route) {
            level5(navController = navController)
        }

        composable(Routes.level6.route) {
            level6(navController = navController)
        }

        composable(Routes.level7.route) {
            level7(navController = navController)
        }

        composable(Routes.level8.route) {
            level8(navController = navController)
        }

        composable(Routes.level9.route) {
            level9(navController = navController)
        }

        composable(Routes.level10.route) {
            level10(navController = navController)
        }

        composable(Routes.level11.route) {
            level11(navController = navController)
        }

        composable(Routes.level12.route) {
            level12(navController = navController)
        }

        composable(Routes.level13.route) {
            level13(navController = navController)
        }

        composable(Routes.level14.route) {
            level14(navController = navController)
        }

        composable(Routes.level15.route) {
            level15(navController = navController)
        }

        composable(Routes.level16.route) {
            level16(navController = navController)
        }

        composable(Routes.level17.route) {
            level17(navController = navController)
        }

        composable(Routes.level18.route) {
            level18(navController = navController)
        }

        composable(Routes.level19.route) {
            level19(navController = navController)
        }

        composable(Routes.level20.route) {
            level20(navController = navController)
        }

        composable(Routes.congrats.route) {
            congrats(navController = navController)
        }

        composable(Routes.status.route) {
            status(navController = navController)
        }

        composable(Routes.rulesdrawer.route) {
            rulesdrawer(navController = navController)
        }

        composable(Routes.tesla.route) {
            tesla(navController = navController)
        }

        composable(Routes.eel.route) {
            eel(navController = navController)
        }

        composable(Routes.developer.route) {
            developer(navController = navController)
        }
    }
}