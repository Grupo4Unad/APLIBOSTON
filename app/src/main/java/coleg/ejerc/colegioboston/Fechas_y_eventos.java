package coleg.ejerc.colegioboston;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

public class Fechas_y_eventos extends AppCompatActivity {
    //private myDatabaseHandle myDatabaseHandle;
    //private TextView calendarText;
    private SQLiteDatabase sqLiteDatabase;
    private misqliteDBMac dbHandler;
    private EditText editText;
    private CalendarView calendarView;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fechas_y_eventos);

        editText=findViewById(R.id.et_nombre_evento);
        calendarView=findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate=Integer.toString(year)+Integer.toString(month)+Integer.toString(dayOfMonth);
                ReadDatabase(view);
                // ReadEvent(view);
            }
        });


        try{
            dbHandler=new misqliteDBMac(this,"CalendarDatabase", null, 1);
            sqLiteDatabase=dbHandler.getWritableDatabase();
            //String createTable="CREATE TABLE CalendarEvent(Data TEXT, Event TEXT)";
            sqLiteDatabase.execSQL("CREATE TABLE EventCalendar(Date TEXT, Event TEXT)");


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void InsertDatabase(View view){
        ContentValues contentValues=new ContentValues();
        contentValues.put("Date",selectedDate);
        contentValues.put("Event", editText.getText().toString());
        sqLiteDatabase.insert("EventCalendar",null, contentValues);


    }
    public void ReadDatabase (View view){
        String query="Select Event from EventCalendar  where Date="+ selectedDate;
        try {
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            cursor.moveToFirst();
            editText.setText(cursor.getString (0));

        }
        catch (Exception e){
            e.printStackTrace();
            editText.setText("");
        }
    }
}