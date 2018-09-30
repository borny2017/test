package de.mockito;

public class ServiceImpl implements Service{
	
	private String parameter;

	@Override
	public Result execute() {
		Result result = null;
		if(this.parameter==null) {
			result = new Result();
			result.setErrorCode(-1);
			result.setMessage("Parameter is null");
		} else {
			result = new Result();
			result.setErrorCode(0);
		}
		return result;
	}

	@Override
	public boolean verify() {
		return false;
	}

}
