package web.project.core.results;

import web.project.core.results.Result;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }
    public SuccessResult(String message) {
        super(true,message);
    }
}
