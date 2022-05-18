package LDUBGD.Inspector.service;

public interface TypeModeService {
	
	static TypeModeService getInstance () {
		return new HashMapTypeModeService();
		}
	
	Type getType (long chatId);
	void setType (long chatId, Type type);
	
}
