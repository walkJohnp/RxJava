/**
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx;

/**
 * 观察者抽象
 *
 * 提供一个用于接收基于推送的通知的机制
 *
 * Provides a mechanism for receiving push-based notifications.
 * <p>
 * After an Observer calls an {@link Observable}'s {@link Observable#subscribe subscribe} method, the
 * {@code Observable} calls the Observer's {@link #onNext} method to provide notifications. A well-behaved
 * {@code Observable} will call an Observer's {@link #onCompleted} method exactly once or the Observer's
 * {@link #onError} method exactly once.
 *
 * @see <a href="http://reactivex.io/documentation/observable.html">ReactiveX documentation: Observable</a>
 * @param <T>
 *          the type of item the Observer expects to observe
 */
public interface Observer<T> {

    /**
     * Observable 提醒Observer 它已经完成发送 基于推送的通知
     *
     * Notifies the Observer that the {@link Observable} has finished sending push-based notifications.
     * <p>
     * The {@link Observable} will not call this method if it calls {@link #onError}.
     */
    void onCompleted();

    /**
     * Observable提醒Observer 经历了一个错误状态
     *
     * 如果调用了这个方法，之后它将不会再去调用 Observer.onNext() 和 Observer.onCompleted()方法
     *
     * Notifies the Observer that the {@link Observable} has experienced an error condition.
     * <p>
     * If the {@link Observable} calls this method, it will not thereafter call {@link #onNext} or
     * {@link #onCompleted}.
     *
     * @param e
     *          the exception encountered by the Observable
     */
    void onError(Throwable e);

    /**
     * 给观察者提供了一个新的数据去观测
     *
     * 这个方法可能被 Observable调用多次，如果调用了 onCompleted() 和 onError() 将不会再调用这个方法
     *
     * Provides the Observer with a new item to observe.
     * <p>
     * The {@link Observable} may call this method 0 or more times.
     * <p>
     * The {@code Observable} will not call this method again after it calls either {@link #onCompleted} or
     * {@link #onError}.
     *
     * @param t
     *          the item emitted by the Observable
     */
    void onNext(T t);

}
