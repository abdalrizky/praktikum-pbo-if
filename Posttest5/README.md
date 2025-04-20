# Posttest 5
Berikut beberapa perubahan yang diterapkan pada posttest ini.
1. Class `User` ditandai abstract karena tidak akan dibuat objeknya dan hanya diturunkan ke sub-class.
2. Method `generateId()` pada class `User` ditandai abstract. Implementasinya diletakkan pada sub-class.
3. Class `Operator` dan `Visitor` diberikan keyword final karena tidak akan diturunkan lagi.
4. Atribut `id` ditandai final untuk mencegah perubahan setelah pertama kali diisi.
5. Method `showParkingSlots()` ditandai final agar implementasinya tidak bisa diubah pada sub-class.
