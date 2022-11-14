import scala.io.StdIn.readLine
object App {
def main(args : Array[String]): Unit ={
   //Создайте ваш первый проект, который печатает на экран фразу «Hello, Scala!».
   println("Hello, Scala!")
   //выводит фразу «Hello, Scala!» справа налево
   val hello =  "Hello, Scala!"
   println(hello.reverse)
   //переводит всю фразу в нижний регистр
   println(hello.toLowerCase)
   //удаляет символ!
   println(hello.replace("!",""))
   //добавляет в конец фразы «and goodbye python!»
   println(hello + "and goodbye python!")

   /*
   * b.     Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов.
   *      На вход вашей программе подается значение годового дохода до вычета налогов,
   *      размер премии – в процентах от годового дохода и
   *      компенсация питания.
   * */
   println("**********************************")
   println("Введите значение годового дохода до вычета налогов")
   val YearProfitBeforeTax = readLine().toFloat

   println("Введите размер премии в процентах от годового дохода (от 0 до 100%)")
   val ProfitPercent = readLine().toFloat

   println("Введите компенсацию питания в абсолютном значении")
   val Compensation = readLine().toFloat

   println("Введите размер налога в процентном соотношении, введите 13 для принятия стандартного налога в 13%, (от 0 до 100%)")
   val Tax = readLine().toFloat

   val YearProfit =  YearProfitBeforeTax + ((ProfitPercent/100)*YearProfitBeforeTax) + Compensation
   var YearProfitAferTax = YearProfit - (YearProfit*Tax/100)
   println("Ежемесячный оклад сотрудника после вычета налогов c учетом премии и компенсации ", (YearProfitAferTax/12).round)
/*
* Напишите программу, которая рассчитывает для каждого сотрудника отклонение(в процентах) от среднего значения оклада
*  на уровень всего отдела. В итоговом значении должно учитываться в большую или меньшую сторону отклоняется размер оклада.
*  На вход вышей программе подаются все значения, аналогичные предыдущей программе,
*  а также список со значениями окладов сотрудников отдела 100, 150, 200, 80, 120, 75.
* */
   var Salarys = List[Float](100, 150, 200, 80, 120, 75)
   val avg =  Salarys.sum/Salarys.size

   val deviation = (( avg - YearProfitAferTax/12 )/ avg)*100
   println("Отклонение от средней зарплаты (",avg,") по отделу ", deviation ,"%")

/*Попробуйте рассчитать новую зарплату сотрудника,
добавив(или отняв, если сотрудник плохо себя вел) необходимую сумму с учетом результатов прошлого задания.
Добавьте его зарплату в список и вычислите значение самой высокой зарплаты и самой низкой.

Трактую как привести к средней.
* */
   var MounthProfitAferTax: Float =  avg

   Salarys = MounthProfitAferTax :: Salarys
   println(Salarys)
/*
* Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
*  Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему
* */
   Salarys = 350 :: Salarys
   Salarys = 90 :: Salarys
   Salarys = Salarys.sorted
   println(Salarys)

   /*.     Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
   Вычислите самостоятельно номер сотрудника в списке так, чтобы сортировка не нарушилась и добавьте его на это место.

   Не нашел нормального алгоритма добавления элемента в произвольное место списка.
   Есть вариант такой, но как он работает я так и не понял.

   def insert[T](list: List[T], i: Int, value: T) = {
     list.take(i) ++ List(value) ++ list.drop(i)
   }

   * */
  /*
   var ind = 0
   val NewEmployer = 130
   while
   (ind< Salarys.length)
   {
      if (Salarys.lift(ind) > NewEmployer)
         {
             println(Salarys.lift(ind))
         }
     ind+=1
   }
*/
/*
* Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
* На входе программе подается «вилка» зарплаты специалистов уровня middle.
* */
   println("Введите вилку зарплат, от и доь для категории middle")
   val lowSalary = readLine().toFloat
   val hiSalary = readLine().toFloat

    for (x <- Salarys) {
       if ((x >= lowSalary) && (x <= hiSalary)) {
          println("isMiddle = ", Salarys.indexOf(x))
       }
    }
/*
* .     Однако наступил кризис и ваши сотрудники требуют повысить зарплату.
*    Вам необходимо проиндексировать зарплату каждого сотрудника на уровень инфляции – 7%
 */
println("Индексация")
   for (i <- Salarys)
    {
         println(i*1.07)
   }

//   Salarys.foreach( x => x * 1.07)

  // Salarys.foreach( x => println(x))


   //   arr1.foreach(println)
}
}
