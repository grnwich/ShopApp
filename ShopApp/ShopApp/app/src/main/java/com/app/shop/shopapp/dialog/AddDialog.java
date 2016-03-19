package com.app.shop.shopapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.app.shop.shopapp.R;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/11 19:56
 * @version: V1.0
 */
public class AddDialog extends Dialog implements View.OnClickListener {
    private ICallBack callBack;
    public AddDialog setCallBack(ICallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    public AddDialog(Context context) {
        super(context, R.style.Dialog);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.dialog_add);

        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = d.getWidth()-d.getWidth()/4;
        getWindow().setAttributes(p);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_no).setOnClickListener(this);
    }
    public AddDialog setInfo(String str){
        ((TextView)findViewById(R.id.tv_info)).setText("是否添加好友"+str);
        return  this;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_no:
                break;
            case R.id.btn_ok:
                if(callBack!=null)callBack.onClickOk();
                break;
            default:
                break;
        }
        dismiss();

    }
    public interface ICallBack{
        void onClickOk();
    }
}
