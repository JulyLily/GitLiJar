package sl.nim.netease.com.gitlijar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lily.gitlijar.annotation.autoknife.FindKnifeProcess;
import com.lily.gitlijar.annotation.autoknife.FindView;
import com.lily.gitlijar.annotation.autoknife.OnClick;
import com.lily.gitlijar.annotation.autowired.AutoWriedProcess;
import com.lily.gitlijar.toast.ToastUtils;

import sl.nim.netease.com.gitlijar.details.CardViewActivity;
import sl.nim.netease.com.gitlijar.details.ToolBarActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FindKnifeProcess.bind(this);
        AutoWriedProcess.bind(this);

//        btn.setText("click this");
    }

    @OnClick({R.id.toolBar,R.id.cardView})
    public void onClick(View view){
       switch (view.getId()){
           case R.id.toolBar:
               ToolBarActivity.start(this);
               break;
           case R.id.cardView:
               CardViewActivity.start(this);
               break;
               default:
                   ToastUtils.makeText(this,"hello world",ToastUtils.LENGTH_SHORT).show();
               break;
       }
    }
}
