package org.example;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class StreamZipper {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Iterator<T> zipIterator = new Iterator<T>() {
            boolean hasNext1 = iterator1.hasNext();
            boolean hasNext2 = iterator2.hasNext();

            @Override
            public boolean hasNext() {
                return hasNext1 && hasNext2;
            }

            @Override
            public T next() {
                T nextElement1 = null;
                T nextElement2 = null;

                if (hasNext1) {
                    nextElement1 = iterator1.next();
                    hasNext1 = iterator1.hasNext();
                }

                if (hasNext2) {
                    nextElement2 = iterator2.next();
                    hasNext2 = iterator2.hasNext();
                }

                return nextElement1 != null ? nextElement1 : nextElement2;
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zipIterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(6, 7, 8, 9, 10);

        Stream<Integer> zippedStream = zip(stream1, stream2);
        zippedStream.forEach(System.out::println);
    }
}

