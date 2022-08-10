package uz.aziza.testgame_homeworkdars_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomMisolBer()

        rad_group.setOnCheckedChangeListener{ radioGroup, chackedId ->
            if (chackedId == R.id.rad_a && rad_a.text.toString().toInt() == tJavob){
                Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()
            }
            if (chackedId == R.id.rad_b && rad_b.text.toString().toInt() == tJavob){
                Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()
            }
            if (chackedId == R.id.rad_c && rad_c.text.toString().toInt() == tJavob){
                Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()
            }
            if (chackedId == R.id.rad_d && rad_d.text.toString().toInt() == tJavob){
                Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()
            }
            rad_a.isChecked = false
            rad_b.isChecked = false
            rad_c.isChecked = false
            rad_d.isChecked = false
            randomMisolBer()
        }
    }

    var number1 = 0
    var number2 = 0
    var amal = 0
    var tJavob = 0
    var level = 20

    fun randomMisolBer(){
        number1 = Random.nextInt(level)
        number2 = Random.nextInt(level)
        amal = Random.nextInt(4)

        when(amal){
            0->{
                tJavob = number1 + number2
                tv_misol.text = "$number1 + $number2"
            }
            1->{
                if (number1<number2){
                    randomMisolBer()
                    return
                }
                tJavob = number1 - number2
                tv_misol.text = "$number1 - $number2"
            }
            2->{
                tJavob = number1 * number2
                tv_misol.text = "$number1 * $number2"
            }
            3->{
                try{
                    if (number1%number2!=0){
                        throw Exception()
                    }
                    tJavob = number1 / number2
                    tv_misol.text = "$number1 / $number2"
                }catch (e:Exception){
                    randomMisolBer()
                }
            }
        }
        randomJavobJoyla()
    }
    var tjj = 0
    fun randomJavobJoyla(){
         tjj = Random.nextInt(4)

        when(tjj){
            0->{
                rad_a.text = tJavob.toString()
                rad_b.text = Random.nextInt(20).toString()
                rad_c.text = Random.nextInt(20).toString()
                rad_d.text = Random.nextInt(20).toString()
            }
            1->{
                rad_a.text = Random.nextInt(20).toString()
                rad_b.text = tJavob.toString()
                rad_c.text = Random.nextInt(20).toString()
                rad_d.text = Random.nextInt(20).toString()
            }
            2->{
                rad_a.text = Random.nextInt(100).toString()
                rad_b.text = Random.nextInt(100).toString()
                rad_c.text = tJavob.toString()
                rad_d.text = Random.nextInt(100).toString()
            }
            3->{
                rad_a.text = Random.nextInt(99).toString()
                rad_b.text = Random.nextInt(99).toString()
                rad_c.text = Random.nextInt(99).toString()
                rad_d.text = tJavob.toString()
            }
        }
    }
}