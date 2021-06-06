package br.com.cotemig.nflcotemig.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.nflcotemig.R
import br.com.cotemig.nflcotemig.model.Standings
import br.com.cotemig.nflcotemig.service.RetrofitInitializer
import br.com.cotemig.nflcotemig.ui.adapters.TableAdapter
import kotlinx.android.synthetic.main.activity_standings.*
import retrofit2.Call
import retrofit2.Response

class StandingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standings)

        getStanding()

    }

    fun getStanding() {

        var s = RetrofitInitializer().serviceListaStandings()

        var call = s.getStanding()

        call.enqueue(object : retrofit2.Callback<List<Standings>> {
            override fun onResponse(call: Call<List<Standings>>, response: Response<List<Standings>>) {

                response?.let {
                    if (response.code() == 200) {
                        response.body()?.let {
                            table.adapter = TableAdapter(this@StandingsActivity, it)
                            table.layoutManager = LinearLayoutManager(this@StandingsActivity, LinearLayoutManager.VERTICAL, false)
                            //Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_LONG).show()
                        }
                    }
                }

            }

            override fun onFailure(call: Call<List<Standings>>, t: Throwable) {
                Toast.makeText(this@StandingsActivity, "erroStandings", Toast.LENGTH_LONG).show()
            }
        })

    }

}