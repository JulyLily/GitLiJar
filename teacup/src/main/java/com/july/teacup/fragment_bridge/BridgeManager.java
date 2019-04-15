package com.july.teacup.fragment_bridge;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class BridgeManager {

    private static BridgeManager bridgeManager;

    public BridgeManager() {

        mBridgeNoParamNoResult = new HashMap<>();
        mBridgeWithParamOnly = new HashMap<>();
        mBridgeWithResultOnly = new HashMap<>();
        mBridgeWithParamWithResult = new HashMap<>();
    }

    public static BridgeManager getInstance() {

        if (bridgeManager == null) {
            synchronized (BridgeManager.class) {
                if (bridgeManager == null) {
                    bridgeManager = new BridgeManager();
                }
            }
        }

        return bridgeManager;
    }

    private Map<String, BridgeNoParamNoResult> mBridgeNoParamNoResult;
    private Map<String, BridgeWithParamOnly> mBridgeWithParamOnly;
    private Map<String, BridgeWithResultOnly> mBridgeWithResultOnly;
    private Map<String, BridgeWithParamWithResult> mBridgeWithParamWithResult;


    public BridgeManager addBridge(BridgeNoParamNoResult mBridge) {
        mBridgeNoParamNoResult.put(mBridge.interfaceName, mBridge);
        return this;
    }

    public BridgeManager addBridge(BridgeWithParamOnly mBridge) {
        mBridgeWithParamOnly.put(mBridge.interfaceName, mBridge);
        return this;
    }

    public BridgeManager addBridge(BridgeWithResultOnly mBridge) {
        mBridgeWithResultOnly.put(mBridge.interfaceName, mBridge);
        return this;
    }

    public BridgeManager addBridge(BridgeWithParamWithResult mBridge) {
        mBridgeWithParamWithResult.put(mBridge.interfaceName, mBridge);
        return this;
    }

    /**
     *  无参数
     * @param bridgeName
     */
    public void invoke(String bridgeName) {
        if (TextUtils.isEmpty(bridgeName)) {
            return;
        }

        if (!TextUtils.isEmpty(mBridgeNoParamNoResult.get(bridgeName).interfaceName)) {

            BridgeNoParamNoResult nPnR = mBridgeNoParamNoResult.get(bridgeName);

            nPnR.bridge();
        }

    }

    /**
     *  仅有参数
     * @param bridgeName
     * @param param
     * @param <Param>
     *
     */
    public <Param> void invoke(String bridgeName, Param param) {
        if (TextUtils.isEmpty(bridgeName)) {
            return;
        }

        if (mBridgeWithParamOnly != null) {

            BridgeWithParamOnly oP = mBridgeWithParamOnly.get(bridgeName);

            if (oP != null) {
                oP.bridge(param);
            }

            if (oP == null) {
                throw new IllegalArgumentException();
            }
        }

    }

    /**
     *  仅有返回值
     * @param bridgeName
     * @param c
     * @param <Result>
     * @return
     */
    public <Result> Result invoke(String bridgeName, Class<Result> c) {
        if (TextUtils.isEmpty(bridgeName)) {
            return null;
        }


        if (mBridgeWithResultOnly != null) {
            BridgeWithResultOnly oR = mBridgeWithResultOnly.get(bridgeName);

            if (oR != null) {
                if (c != null) {
                    return c.cast(oR.bridge());
                } else {
                    return (Result) oR.bridge();
                }
            }


            if (oR == null) {
                throw new IllegalArgumentException();
            }
        }

        return null;

    }

    /**
     *  有参数和返回值
     * @param bridgeName
     * @param param
     * @param c
     * @param <Param>
     * @param <Result>
     * @return
     */
    public <Param,Result> Result invoke(String bridgeName, Param param, Class<Result> c) {
        if (TextUtils.isEmpty(bridgeName)) {
            return null;
        }

        if (mBridgeWithParamWithResult != null) {

            BridgeWithParamWithResult<Param, Result> wPwR = mBridgeWithParamWithResult.get(bridgeName);

            if (wPwR != null) {

                if (c != null) {
                    return c.cast(wPwR.bridge(param));
                } else {
                    return wPwR.bridge(param);
                }
            }

            if (wPwR == null) {
                throw new IllegalArgumentException();
            }

        }

        return null;
    }
}
