
在Java中，处理文件I/O（输入/输出）的常用类主要位于 `java.io`包中。以下是一些常用的类，按照它们的功能进行分类：

### 1. 文件操作类

- **File**：表示文件和目录路径名的抽象表示。用于创建、删除文件或目录，查询文件属性等。
- 常用方法：`exists()`, `isFile()`, `isDirectory()`, `createNewFile()`, `mkdir()`, `mkdirs()`, `delete()`, `renameTo()`, `listFiles()`, `getPath()`, `getName()`, `length()`等。

### 2. 字节流（Byte Streams） - 用于处理二进制数据（如图片、视频等）

- **InputStream**：所有字节输入流的抽象基类。
- **FileInputStream**：从文件中读取字节数据。
- **BufferedInputStream**：为另一个输入流提供缓冲功能，提高读取效率。
- **DataInputStream**：允许以Java基本数据类型的形式读取数据。
- **ObjectInputStream**：用于从输入流中读取对象（反序列化）。
- **OutputStream**：所有字节输出流的抽象基类。
- **FileOutputStream**：向文件中写入字节数据。
- **BufferedOutputStream**：为另一个输出流提供缓冲功能，提高写入效率。
- **DataOutputStream**：允许以Java基本数据类型的形式写入数据。
- **ObjectOutputStream**：用于将对象写入输出流（序列化）。
- **PrintStream**：提供各种打印方法，如 `print()`, `println()`等。通常用于标准输出（System.out）和文件输出。

### 3. 字符流（Character Streams） - 用于处理文本数据（如txt文件）

- **Reader**：所有字符输入流的抽象基类。
- **FileReader**：从文件中读取字符数据（使用默认字符编码）。
- **BufferedReader**：为另一个字符输入流提供缓冲功能，提高读取效率。常用方法 `readLine()`可以一次读取一行文本。
- **InputStreamReader**：将字节流转换为字符流，可以指定字符编码。通常用于从字节流（如网络连接）读取文本。
- **Writer**：所有字符输出流的抽象基类。
- **FileWriter**：向文件中写入字符数据（使用默认字符编码）。
- **BufferedWriter**：为另一个字符输出流提供缓冲功能，提高写入效率。常用方法 `newLine()`可以写入一个行分隔符。
- **OutputStreamWriter**：将字符流转换为字节流，可以指定字符编码。通常用于将文本写入字节流（如网络连接）。
- **PrintWriter**：提供各种打印方法，如 `print()`, `println()`等。可以包装 `FileWriter`或 `OutputStreamWriter`，并支持自动刷新。

### 4. 其他实用类

- **Scanner**：位于 `java.util`包中，用于解析文本数据（如从文件或标准输入读取）。它使用正则表达式来解析基本类型和字符串。

### 示例代码

#### 使用字节流复制文件

```java

try (FileInputStream fis = new FileInputStream("source.txt");

FileOutputStream fos = new FileOutputStream("target.txt")) {

byte[] buffer = new byte[1024];

int length;

while ((length = fis.read(buffer)) != -1) {

fos.write(buffer, 0, length);

}

} catch (IOException e) {

e.printStackTrace();

}

```

#### 使用字符流读取文本文件（按行读取）

```java

try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {

String line;

while ((line = reader.readLine()) != null) {

System.out.println(line);

}

} catch (IOException e) {

e.printStackTrace();

}

```

#### 使用字符流写入文本文件

```java

try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

writer.write("Hello, World!");

writer.newLine();

writer.write("This is a new line.");

} catch (IOException e) {

e.printStackTrace();

}

```

#### 使用PrintWriter写入文本文件（支持格式化输出）

```java

try (PrintWriter writer = new PrintWriter("output.txt")) {

writer.println("Hello, World!");

writer.printf("The value of pi is approximately %.2f.", Math.PI);

} catch (FileNotFoundException e) {

e.printStackTrace();

}

```

#### 使用Scanner读取文本文件

```java

try (Scanner scanner = new Scanner(new File("input.txt"))) {

while (scanner.hasNextLine()) {

String line = scanner.nextLine();

System.out.println(line);

}

} catch (FileNotFoundException e) {

e.printStackTrace();

}

```

### 注意：

1. 以上代码都使用了Java 7引入的try-with-resources语句，确保资源被自动关闭（即使发生异常）。
2. 字符流默认使用平台的默认字符编码，这可能导致跨平台问题。因此，在需要指定编码时，应使用 `InputStreamReader`和 `OutputStreamWriter`，并明确指定字符集（如UTF-8）：

```java

BufferedReader reader = new BufferedReader(

new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8));

```

以上是Java IO中常用的类和方法，忽略 `java.nio`包。这些类在文件读写、序列化、文本处理等方面有广泛应用。
