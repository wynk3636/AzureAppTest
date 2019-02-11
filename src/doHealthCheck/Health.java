package doHealthCheck;
//JavaBeansのモデル

/* JavaBeansのルール
* ①直列化可能である（java.io.Serializableをインポートしている）
* ②クラスはpublicでパッケージに所属する
* ③publicで引数のないコンストラクタを持つ
* ④フィールドはカプセル化されている
* ⑤命名規則に従ったgetter/setterを持つ
*/
import java.io.Serializable;

//JSPで受け取る為にSerializableインターフェースの実装
//インスタンスのフィールドの内容をバイト列に変換してファイルなどに保存して、それをまたインスタンスに復元する技術
@SuppressWarnings("serial")
public class Health implements Serializable {
	//privateカプセル化
	private double height;
	private double weight;
	private double bmi;
	private String bodyType;
	
	public double getHeight() {
	  return height;
	}
	
	public void setHeight(Double height) {
	  this.height = height;
	}
	
	public double getWeight() {
	  return weight;
	}
	
	public void setWeight(Double weight) {
	  this.weight = weight;
	}
	
	public double getBmi() {
	  return bmi;
	}
	
	public void setBmi(Double bmi) {
	  this.bmi = bmi;
	}
	
	public String getBodyType() {
	  return bodyType;
	}
	
	public void setBodyType(String bodyType) {
	  this.bodyType = bodyType;
	}
}