package member;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import account.FileDB;

public class MemberObjFileMapDao extends MemberMapDao implements FileDB{

	private String dbFilename;
	
	public MemberObjFileMapDao(String dbFilename) {
		this.dbFilename = dbFilename;
	}
	
	@Override
	public boolean loadDB() {
		try(
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbFilename))
				) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveDB() {
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbFilename))
				) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
