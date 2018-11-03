package jabosystems;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.pagehelper.PageInfo;
import com.ks.jabosystems.biz.BxVoBiz;
import com.ks.jabosystems.biz.EmployeeBiz;
import com.ks.jabosystems.pojo.Checkresult;
import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.pojo.Voucher;
import com.ks.jabosystems.vo.BxVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-ctx.xml" })
public class BizTest {

	@Autowired
	private EmployeeBiz EmployeeBiz;

	@Autowired
	private BxVoBiz BxVoBiz;

	@Test
	public void findEmployeeByenamewithepwdtest() throws Exception {
		Employee Employee1 = new Employee("001", "彭老狗", "123", 1, 1, 002);
		Employee Employee = EmployeeBiz.findEmployeeByenamewithepwd(Employee1);
		System.out.println(Employee);
	}

	@Test
	public void findEmployeeListTest() throws Exception {
		List<Employee> list = EmployeeBiz.findEmployeeList();
		System.out.println(list);
	}

	@Test
	public void findBxvoByeid() throws Exception {
		Employee Employee = new Employee("003", "晟哥", "123", 1, 1, 0);
		PageInfo<BxVo> data = BxVoBiz.findBxvoByeid(Employee, 1, 3);
		for (BxVo d : data.getList()) {
			for (Voucher v : d.getVoucher()) {
				System.out.println(v.getVc_id());
				for (Checkresult c : v.getCheckresult()) {
					System.out.println(c.getStatus());
				}
			}
		}
	}

	@Test
	public void findnextEmployeeByeid() throws Exception {
		Employee Employee = new Employee("003", "晟哥", "123", 1, 1, 0);
		Employee Employee1 = EmployeeBiz.findEmployeeByeid(Employee);
		Employee Employee2 = EmployeeBiz.findnextEmployeeByeid(Employee);
		System.out.println(Employee1);
		System.out.println(Employee2);
	}

}
