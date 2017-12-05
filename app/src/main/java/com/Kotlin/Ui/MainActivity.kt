package com.Kotlin.Ui


import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.TextView
import android.widget.Toast
import com.Kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.joda.time.LocalDate
import org.joda.time.Period
import org.joda.time.PeriodType
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    //All variables are declared here
    var booleanDob: Boolean = true
    var booleanCurrentDate: Boolean = false
    var dateDob: Date = Date()
    var dateTo: Date = Date()
    var dateDob1: Date = Date()
    var dateTo1: Date = Date()
    var year: Int = 0;
    var month: Int = 0;
    var day: Int = 0;
    var year1: Int = 0;
    var month1: Int = 0;
    var day1: Int = 0;
    var period: Period = Period()

    //On create method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //All on clicks are initialized
        llDob.setOnClickListener {
            booleanDob = true;
            booleanCurrentDate = false
            getSelectedDate();
        }
        llToDate.setOnClickListener {
            booleanCurrentDate = true;
            booleanDob = false
            getSelectedDate();
        }
        btnCal.setOnClickListener {
            //Html formatt for string ui deprecated in N so this codition is used
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                //GetDiffYears() will return string of caluculated age and displayed in text view
                tvResult.setText(Html.fromHtml(getDiffYears(), Html.FROM_HTML_MODE_LEGACY), TextView.BufferType.SPANNABLE);
            } else {
                //Method getDiffYears() will return string of caluculated age and displayed in text view
                tvResult.setText(Html.fromHtml(getDiffYears()), TextView.BufferType.SPANNABLE);
            }
//Caluclate functionality
            resultFun()
        }
        //Initial functionality to save current date for both fields
        initFun()
    }

    //Initial functionality to save current date for both fields
    private fun initFun() {
        //To get local date to set initial fields
        val date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        dateDob = formatter.parse(date) as Date
        //Intial year,month,day fieilds for DOB
        val dfY = SimpleDateFormat("yyyy", Locale.getDefault())
        year = dfY.format(dateDob).toInt()
        val dfM = SimpleDateFormat("M", Locale.getDefault())
        month = dfM.format(dateDob).toInt()
        val dfD = SimpleDateFormat("d", Locale.getDefault())
        day = dfD.format(dateDob).toInt()
        //intial year,month,day fieilds for To-date
        val dfY1 = SimpleDateFormat("yyyy", Locale.getDefault())
        year1 = dfY1.format(dateDob).toInt()
        val dfM1 = SimpleDateFormat("M", Locale.getDefault())
        month1 = dfM1.format(dateDob).toInt()
        val dfD1 = SimpleDateFormat("d", Locale.getDefault())
        day1 = dfD1.format(dateDob).toInt()

        dateTo = formatter.parse(date) as Date
        dateDob1 = formatter.parse(date) as Date
        dateTo1 = formatter.parse(date) as Date

        tvTo.text = "$day-$month-$year"
        tvDob.text = "$day-$month-$year"
    }

    //Caluclate functionality for final message
    private fun resultFun() {
//When is used to differentiate messages
        when (period.years) {
        //Here in 0..5 means  between 0 to 5
            in 0..5 -> {

                tvMessage.text = "you are so Cute.."
                imgMsg.setBackgroundResource(R.drawable.cute)
            }
            in 6..15 -> {
                tvMessage.text = "you are Growing"
                imgMsg.setBackgroundResource(R.drawable.children)
            }
            in 16..21 -> {
                tvMessage.text = "you are at Teenage be conscious"
                imgMsg.setBackgroundResource(R.drawable.cool)
            }
            in 22..30 -> {
                tvMessage.text = "You are Young ready to fight"
                imgMsg.setBackgroundResource(R.drawable.success)

            }
            in 31..50 -> {
                tvMessage.text = "You are Adult take care of your health"
                imgMsg.setBackgroundResource(R.drawable.heart)
            }
            in 51..100 -> {
                tvMessage.text = "You are growing older but looks so adorable"
                imgMsg.setBackgroundResource(R.drawable.couple)
            }

            else -> {
                tvMessage.text = "Are you yogi!! or any saint!!"
                imgMsg.setBackgroundResource(R.drawable.christianity)
            }
        }


    }

    //Functionality to retrive selected date form dob and to-date
    fun getSelectedDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        var str_date: String? = null;
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // Display Selected date in textbox

            if (booleanDob) {
                val x: Int = monthOfYear + 1;
                str_date = "$dayOfMonth-$x-$year"
                val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                dateDob1 = formatter.parse(str_date) as Date
                if (dateTo1.compareTo(dateDob1) < 0) {
                    dateDob1 = dateDob
                    Toast.makeText(this, "your DOB is more thann the current date",
                            Toast.LENGTH_LONG).show()
                    return@OnDateSetListener
                } else {

                    dateDob = formatter.parse(str_date) as Date
                    tvDob.text = str_date
                    this.year = year
                    this.month = monthOfYear + 1
                    this.day = dayOfMonth
                }


            } else {
                val x: Int = monthOfYear + 1;
                str_date = "$dayOfMonth-$x-$year"
                val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                dateTo1 = formatter.parse(str_date) as Date

                if (dateTo1.compareTo(dateDob1) < 0) {
                    dateTo1 = dateTo;
                    Toast.makeText(this, "Cureent date is less than your DOB",
                            Toast.LENGTH_LONG).show()
                    return@OnDateSetListener
                } else {
                    dateTo = formatter.parse(str_date) as Date
                    tvTo.setText(str_date)
                    this.year1 = year
                    this.month1 = monthOfYear + 1
                    this.day1 = dayOfMonth
                }

            }
        }, year, month, day)

        dpd.show()
    }


    //Functionality to calculate difference in two dates joda library is used to get exact age in years months and dates
    fun getDiffYears(): String {

        var month: String = month.toString()
        month = if (month.startsWith("0")) month.substring(1) else month
        var month1: String = month1.toString()
        month1 = if (month1.startsWith("0")) month1.substring(1) else month1
        val birthdate = LocalDate(year, month.toInt(), day)          //Birth date
        val now = LocalDate(year1, month1.toInt(), day1)                    //Today's date
        period = Period(birthdate, now, PeriodType.yearMonthDay())
    //When is similar to switch in java used  here to diffrentiate conditions based on age
        return when (true) {
            period.years == 1 && period.months == 1 && period.days == 1 -> {
                "you are <font color='red'>${period.years}</font> year  <font color='red'>${period.months}</font> month and  <font color='red'>${period.days}</font> day old :) "
            }
            period.years == 1 && period.months != 1 && period.days != 1 -> {
                "you are <font color='red'>${period.years}</font> year  <font color='red'>${period.months}</font> month's and  <font color='red'>${period.days}</font> day's old :) "

            }
            period.years != 1 && period.months != 1 && period.days == 1 -> {
                "you are <font color='red'>${period.years}</font> year's  <font color='red'>${period.months}</font> month's and  <font color='red'>${period.days}</font> day old :) "

            }
            period.years != 1 && period.months == 1 && period.days != 1 -> {
                "you are <font color='red'>${period.years}</font> year's  <font color='red'>${period.months}</font> month and  <font color='red'>${period.days}</font> day's old :) "

            }
            period.years == 1 && period.months == 1 && period.days != 1 -> {
                "you are <font color='red'>${period.years}</font> year  <font color='red'>${period.months}</font> month and  <font color='red'>${period.days}</font> day's old :) "

            }
            period.years != 1 && period.months == 1 && period.days == 1 -> {
                "you are <font color='red'>${period.years}</font> year's  <font color='red'>${period.months}</font> month and  <font color='red'>${period.days}</font> day old :) "

            }
            period.years == 1 && period.months != 1 && period.days == 1 -> {
                "you are <font color='red'>${period.years}</font> year  <font color='red'>${period.months}</font> month's and  <font color='red'>${period.days}</font> day old :) "

            }

            else -> {
                "you are <font color='red'>${period.years}</font> year's  <font color='red'>${period.months}</font> month's and  <font color='red'>${period.days}</font> day's old :) "

            }
        }
    }


}
