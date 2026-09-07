package member;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import account.FileDB;

public class MemberDataFileMapDao extends MemberMapDao implements FileDB{

	private String dbFilename;
	
	public MemberDataFileMapDao(String dbFilename) {
		this.dbFilename = dbFilename;
	}

	@Override
	public boolean loadDB() {
		
		try (DataInputStream dis = new DataInputStream(new FileInputStream(dbFilename))) {
			
			while (true) {
				String id = dis.readUTF();
				String nickname = dis.readUTF();
				String password = dis.readUTF();
//			int age = dis.readInt();	정수형을 읽어올때 사용
				insertMember(new Member(id, nickname, password));				
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean saveDB() {
		// DataOutputStream - FileOutputStream
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(dbFilename))) {
			
			// memberDB 저장
			for (Member m : memberDB.values()) {
				dos.writeUTF(m.getId());
				dos.writeUTF(m.getNickname());
				dos.writeUTF(m.getPassword());
//				dos.writeInt(m.getAge()); 정수형을 저장할때 사용
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertMember(Member m) {
		super.insertMember(m);
		return saveDB();
	}
	
	
}
