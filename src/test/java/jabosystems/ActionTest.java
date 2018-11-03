package jabosystems;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.github.pagehelper.PageInfo;
import com.ks.jabosystems.pojo.Checkresult;
import com.ks.jabosystems.pojo.Voucher;
import com.ks.jabosystems.vo.BxVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-web.xml" })
@WebAppConfiguration
public class ActionTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void initMockMvc() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void bxlist() throws Exception{
		MvcResult rs = mockMvc.perform(get("/Employee/bxlist?pageNum=1&pageSize=3")).andExpect(status().isOk()).andDo(print()).andReturn();
		PageInfo<BxVo> data = (PageInfo<BxVo>) rs.getModelAndView().getModel().get("data");
		for (BxVo d : data.getList()) {
			for (Voucher v : d.getVoucher()) {
				System.out.println(v.getVc_id());
				for (Checkresult c : v.getCheckresult()) {
					System.out.println(c.getStatus());
				}
			}
		}
	}
}
