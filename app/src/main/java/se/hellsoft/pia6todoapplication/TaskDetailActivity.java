package se.hellsoft.pia6todoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class TaskDetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_TASK = "task";
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);
        Button deleteButton = (Button) findViewById(R.id.delete_button);

        // Get the task that we might have received
        Intent intent = getIntent();
        task = intent.getParcelableExtra(KEY_TASK);

        if (task != null) {
            // Add click listener only for an existing Task
            deleteButton.setOnClickListener(this);
        } else {
            // Don't show if task is null (new Task!)
            deleteButton.setVisibility(View.INVISIBLE);
        }

        // Only update the field if we have an existing task
        if (task != null) {
            EditText title = (EditText) findViewById(R.id.title);
            title.setText(task.getTitle());
            EditText description = (EditText) findViewById(R.id.description);
            description.setText(task.getDescription());
            CheckBox completed = (CheckBox) findViewById(R.id.completed);
            completed.setChecked(task.isCompleted());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_button:
                saveOrCreateTask();
                break;
            case R.id.delete_button:
                deleteTask();
                break;
        }

    }

    private void deleteTask() {

    }

    private void saveOrCreateTask() {

    }
}
