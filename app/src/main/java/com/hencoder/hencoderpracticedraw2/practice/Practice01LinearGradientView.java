package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Shader shader;
        float cx = 300;
        float cy = 300;
        float radius = 200;

        float x0 = cx - radius;
        float y0 = cy - radius;
        float x1 = cx + radius;
        float y1 = cy + radius;

        shader = new LinearGradient(x0, y0, x1, y1, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);

        paint.setShader(shader);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, radius, paint);
    }
}
