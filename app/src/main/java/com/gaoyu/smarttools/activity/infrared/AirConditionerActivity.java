package com.gaoyu.smarttools.activity.infrared;

import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gaoyu.smarttools.activity.BaseActivity;
import com.gaoyu.smarttools.R;
import com.gaoyu.smarttools.date.CodeCommand;


/**
 * ============说明==============
 * <p>
 * 发射红外方法
 * transmit(int carrierFrequency, int[] pattern)
 * <p>
 * carrierFrequency代表红外传输的频率，一般的遥控板都是38KHz。
 * pattern就是指以微妙为单位的红外开和关的交替时间。
 * <p>
 * pattern={9000，4500，600，1600}；
 * 代表红外先打开9000微秒 再关闭4500微秒 再打开600微秒……..依次类推。
 * 但是要注意，整个数组的时间之和不能超过两秒。还有就是这里的
 * ***开对应的是示波器上的  低电平，关对应的  高电平。***
 * 也就是说偶数位对应的是低电平，奇数位对应的是高电平。
 * 然后只要你能找到对应遥控器的编码基本上就能够做到用手机遥控了。
 *
 */

//需要api大于19与下面if判断用途类似
@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class AirConditionerActivity extends BaseActivity implements View.OnClickListener {
    //获取红外控制类
    private ConsumerIrManager IR;
    //显示详细信息
    private TextView tv_detail;
    private Button btn_AirConditioner_GL;
    //判断是否有红外功能
    boolean IRBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infrared);
        inItEvent();
        inItUI();
    }


    //初始化UI
    private void inItUI() {
        tv_detail = (TextView) findViewById(R.id.tv_detail);
        btn_AirConditioner_GL = (Button) findViewById(R.id.btn_AirConditioner_GL);
        btn_AirConditioner_GL.setOnClickListener(this);
    }


    //初始化事务
    private void inItEvent() {
        //获取ConsumerIrManager实例
        IR = (ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE);

        //如果sdk版本大于4.4才进行是否有红外的功能（手机的android版本）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            IRBack = IR.hasIrEmitter();
            if (!IRBack) {
                showToast("对不起，该设备上没有红外功能!");
            } else {
                showToast("红外设备就绪");//可进行下一步操作
            }
        }
    }

    /**
     * 发射红外信号
     * 可以查看这个标签的log   ConsumerIr
     * @param carrierFrequency 红外传输的频率，一般的遥控板都是38KHz
     * @param pattern          指以微秒为单位的红外开和关的交替时间
     */
    private void sendMsg(int carrierFrequency, int[] pattern) {
        IR.transmit(carrierFrequency, pattern);

        showToast("发送成功");
        String content = null;
        for(int i = 0;i<pattern.length;i++){
            content += String.valueOf(pattern[i])+",";
        }
        tv_detail.setText(content+"\n"+(pattern.length)+"个时间数据");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_AirConditioner_GL:
                if (IRBack) {
                    sendMsg(38000, CodeCommand.auto);
                } else {
                    showToast("对不起，该设备上没有红外功能!");
                }
                break;
        }
    }
}
