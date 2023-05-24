import jakarta.servlet.ServletException
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@WebServlet(name = "HelloServlet", value = ["/helloservlet"])
class HelloServlet : HttpServlet() {
    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, res: HttpServletResponse) {
        servletContext.log("Client IP: ${req.remoteAddr}")
        servletContext.log("Params: ${req.parameterMap}")
        servletContext.log("Request method: ${req.method}")
        servletContext.log("User-agent: ${req.getHeader("User-Agent")}")

        val param1 = req.getParameter("param1")
        val param2 = req.getParameter("param2").toInt()
        val bool = req.getParameter("bool").toBoolean()

        if (bool) {
            res.writer.println("Success")
        } else {
            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
            val line = "${param1.repeat(param2)}, $timestamp\n"
            val file = File("template.html")
            FileWriter(file, true).use { it.write(line) }
            res.contentType = "text/html"
            res.writer.println("<html><body>")
            res.writer.println("<div>")
            res.writer.println(file.readText())
            res.writer.println("</div>")
            res.writer.println("</body></html>")
        }
    }
}