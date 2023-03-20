public class Worker {
    private final int ERROR_INDEX = 33;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback,
                  OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != ERROR_INDEX) {
                callback.onDone("Task " + i + " is done.");
            } else {
                errorCallback.onError("Task " + i +
                        " is not done. Error happened.");
            }
        }
    }
}