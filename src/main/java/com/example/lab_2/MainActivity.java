package com.example.lab_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private GestureDetector gestureDetector;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.gesture_info);
        gestureDetector = new GestureDetector(this, new GestureListener());
        textView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));
        show();
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            textView.setText("Одиночное нажатие");
            Toast.makeText(MainActivity.this, "Обнаружено однократное нажатие", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            textView.setText("Двойное нажатие");
            Toast.makeText(MainActivity.this, "Обнаружено двойное нажатие", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            textView.setText("Скольжение");
            Toast.makeText(MainActivity.this, "Обнаружено скольжение", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            textView.setText("Длительное нажатие");
            Toast.makeText(MainActivity.this, "Обнаружено длительное нажатие", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            textView.setText("Пролистывание");
            Toast.makeText(MainActivity.this, "Обнаружено пролистывание", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.gestures || id == R.id.info) {
            handleMenuItem(id);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleMenuItem(int id) {
        if (id == R.id.gestures) {
            showGestures();
        } else if (id == R.id.info) {
            show();
        }
    }

    private void showGestures() {
        textView.setText("Выполните жест на экране.");
    }

    private void show() {
        textView.setText("Это приложение демонстрирует различные стандартные жесты, такие как: \n \n- Одиночное нажатие \n- Двойное нажатие \n- Длительное нажатие \n- Прокрутка \n- Скольжение");
    }
}